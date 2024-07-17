"use client";

import MangaCard from "@/components/manga-card";
import {
  Pagination,
  PaginationContent,
  PaginationEllipsis,
  PaginationItem,
  PaginationLink,
  PaginationNext,
  PaginationPrevious,
} from "@/components/ui/pagination";
import { Skeleton } from "@/components/ui/skeleton";
import { Manga } from "@/interfaces/manga";
import { PageInfo } from "@/interfaces/page-info";
import { fetchData } from "@/tools/api";
import { useState, useEffect } from "react";

export default function Home() {
  const [mangas, setMangas] = useState<Manga[] | null>(null);
  const [pageInfo, setPageInfo] = useState<PageInfo | null>(null);

  useEffect(() => {
    fetchMangaPageable();
  }, []);

  const fetchMangaPageable = async (page?: number) => {
    if (page == undefined) {
      page = 0;
    }
    fetchData(`/kyou/pageable?page=${page}`).then((data) => {
      console.log(data);

      setMangas(data.content);
      setPageInfo(data.page);
    });
  };

  const showMangas = () => {
    if (!mangas || mangas.length === 0) {
      return showSkeleton();
    }
    return mangas.map((manga, index) => (
      <MangaCard key={index} manga={manga} />
    ));
  };

  const showSkeleton = () => {
    let skeletons = [];

    for (let i = 0; i < 10; i++) {
      skeletons.push(
        <Skeleton key={i} className="col-span-1 h-64 md:h-96 w-full" />
      );
    }

    return skeletons.map((skeleton) => skeleton);
  };

  const showPaginationItems = () => {
    let items = [];

    let totalPages = pageInfo!.totalPages;
    let qtdPagesCadaParte = totalPages / 2;

    if (qtdPagesCadaParte > 3) {
      qtdPagesCadaParte = 3;
    }

    for (let i = 0; i < qtdPagesCadaParte; i++) {
      items.push(
        <PaginationItem>
          <PaginationLink
            onClick={paginateTo(i)}
            isActive={pageInfo?.number == i}
          >
            {i + 1}
          </PaginationLink>
        </PaginationItem>
      );
    }

    if (qtdPagesCadaParte == 3) {
      items.push(
        <PaginationItem>
          <PaginationEllipsis />
        </PaginationItem>
      );
    }

    for (let i = totalPages - 4; i < qtdPagesCadaParte; i++) {
      items.push(
        <PaginationItem>
          <PaginationLink
            onClick={paginateTo(i)}
            isActive={pageInfo?.number == i}
          >
            {i + 1}
          </PaginationLink>
        </PaginationItem>
      );
    }

    return items.map((item) => item);
  };

  const paginateTo = (page: number) => async () => {
    if ((pageInfo?.totalPages || 0) - 1 >= page) {
      fetchMangaPageable(page);
    }
  };

  return (
    <main>
      <div className="w-full px-16 py-8 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
        <div className="grid grid-cols-subgrid col-span-full row-span-1 gap-4">
          {showMangas()}
        </div>
        <Pagination className="col-span-full row-span-1 flex items-center justify-center">
          <PaginationContent>
            <PaginationItem>
              <PaginationPrevious
                disabled={pageInfo?.number == 0}
                onClick={paginateTo((pageInfo?.number || 0) - 1)}
              />
            </PaginationItem>
            {showPaginationItems()}
            <PaginationItem>
              <PaginationNext
                disabled={pageInfo?.number == (pageInfo?.totalPages || 1) - 1}
                onClick={paginateTo((pageInfo?.number || 0) + 1)}
              />
            </PaginationItem>
          </PaginationContent>
        </Pagination>
      </div>
    </main>
  );
}
