"use client";
import MangaCard from "@/components/manga-card";
import { Skeleton } from "@/components/ui/skeleton";
import { Manga } from "@/interfaces/manga";
import { fetchData } from "@/tools/api";
import { useEffect, useState } from "react";

export default function CatalogoPage() {
  const [mangas, setMangas] = useState<Manga[] | null>(null);

  useEffect(() => {
    fetchData().then((data) => {
      setMangas(data);
    });
  }, []);

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

  return (
    <main>
      <div className="w-full px-16 py-8 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
        {showMangas()}
      </div>
    </main>
  );
}
