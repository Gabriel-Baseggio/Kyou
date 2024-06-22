"use client";

import { Button } from "@/components/ui/button";
import { Skeleton } from "@/components/ui/skeleton";
import { Chapter } from "@/interfaces/chapter";
import { Manga } from "@/interfaces/manga";
import { Page } from "@/interfaces/page";
import { fetchData } from "@/tools/api";
import { useEffect, useState } from "react";
import { ArrowBigLeft } from "../../../../../node_modules/lucide-react/dist/lucide-react";
import {
  usePathname,
  useRouter,
} from "../../../../../node_modules/next/navigation";
import Link from "next/link";

export default function ChapterPage({
  params,
}: {
  params: { title: string; chapter: string };
}) {
  const [manga, setManga] = useState<Manga | null>(null);
  const [chapter, setChapter] = useState<Chapter | null>(null);
  const router = useRouter();
  const pathname = usePathname();

  useEffect(() => {
    fetchData(params.title).then((data) => {
      setManga(data);
      console.log(data);
    });
    fetchData(params.title + "/" + params.chapter).then((data) => {
      setChapter(data);
    });
  }, [params.title]);

  const formatPathname = (pathname: string) => {
    return pathname.split("/").slice(0, -1).join("/");
  };

  const changeChapter = (next: boolean) => {
    let tempChapter: Chapter | undefined;
    for (let i = 0; i < manga?.chapters!.length!; i++) {
      if (manga?.chapters[i].chapter == chapter?.chapter) {
        if (next) {
          tempChapter = manga?.chapters[i + 1];
        } else {
          tempChapter = manga?.chapters[i - 1];
        }
      }
    }
    router.push(formatPathname(pathname) + "/" + tempChapter?.chapter);
  };

  const nextChapter = () => {
    let nextChapter;
    for (let i = 0; i < manga?.chapters!.length!; i++) {
      if (manga?.chapters[i].chapter == chapter?.chapter) {
        nextChapter = manga?.chapters[i + 1];
      }
    }
    router.push(formatPathname(pathname) + "/" + nextChapter?.chapter);
  };

  const findChapter = () => {
    for (let i = 0; i < manga?.chapters!.length!; i++) {
      if (manga?.chapters[i].chapter == chapter?.chapter) {
        return i;
      }
    }
    return null;
  };

  const showChapter = () => {
    if (!chapter) {
      return showSkeleton();
    }
    return (
      <section className="w-1/3 flex flex-col items-center gap-2">
        <div className="w-full flex justify-between">
          <Button
            disabled={findChapter() == 0}
            onClick={() => changeChapter(false)}
          >
            {/* <ArrowBigLeft /> */}
            Anterior
          </Button>
          <Button
            disabled={findChapter() == manga?.chapters!.length! - 1}
            onClick={() => changeChapter(true)}
          >
            {/* <ArrowBigRight /> */}
            Próximo
          </Button>
        </div>
        <div className="w-full">
          {chapter.pages.map((page: Page, key) => {
            return (
              <img
                className="w-full"
                key={key}
                src={page.pageImage}
                alt="Page image"
              />
            );
          })}
        </div>
        <div className="w-full flex justify-between">
          <Button
            disabled={findChapter() == 0}
            onClick={() => changeChapter(false)}
          >
            {/* <ArrowBigLeft /> */}
            Anterior
          </Button>
          <Button
            disabled={findChapter() == manga?.chapters!.length! - 1}
            onClick={() => changeChapter(true)}
          >
            {/* <ArrowBigRight /> */}
            Próximo
          </Button>
        </div>
      </section>
    );
  };

  const showSkeleton = () => {
    return <Skeleton className="col-span-1 h-64 md:h-96 w-full" />;
  };

  return (
    <main className="w-full flex flex-col items-center pt-4 gap-4">
      <Link href={"/manga/" + params.title} className="text-3xl font-bold">
        {manga?.title}
      </Link>
      <h2 className="text-xl font-bold">Capítulo {params.chapter}</h2>
      {showChapter()}
    </main>
  );
}
