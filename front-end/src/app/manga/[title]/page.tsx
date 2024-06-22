"use client";

import { Badge } from "@/components/ui/badge";
import { Skeleton } from "@/components/ui/skeleton";
import { Manga } from "@/interfaces/manga";
import { Status } from "@/interfaces/status";
import { fetchData } from "@/tools/api";
import { useEffect, useState } from "react";

export default function MangaPage({ params }: { params: { title: string } }) {
  let [manga, setManga] = useState<Manga | null>(null);
  let [readMore, setReadMore] = useState<boolean>(false);

  useEffect(() => {
    fetchData(params.title).then((data) => {
      setManga(data);
    });
  }, [params.title]);

  const showCategories = () => {
    if (!manga?.categories || manga.categories.length === 0) {
      return showSkeleton();
    }
    return manga.categories.map((category, index) => (
      <Badge key={index}>{category.category}</Badge>
    ));
  };

  const renderText = () => {
    if (!manga?.description) {
      return showSkeleton();
    }

    let text = manga.description;
    if (!readMore && text.length > 400) {
      text = text.match(/.{1,400}/g)![0];
      text += "...";
    }

    return (
      <div>
        <p>
          {text}
          {text.length > 400 && (
            <button
              className="p-1 text-sm ml-2 text-muted-foreground hover:text-foreground"
              onClick={() => setReadMore(!readMore)}
            >
              Ler {readMore ? "menos" : "mais"}
            </button>
          )}
        </p>
      </div>
    );
  };

  const showManga = () => {
    if (!manga) {
      return showSkeleton();
    }
    return (
      <>
        <div className="w-full h-72">
          <img
            className="w-full h-full object-center object-cover"
            alt="Manga cover"
            src={manga.cover}
          />
        </div>
        <div className="w-full flex">
          <aside className="w-1/4 px-12 -mt-16 gap-3 flex flex-col">
            <div className="flex flex-col items-center">
              <p className="w-1/4 bg-background flex justify-center rounded-t-md ">
                # {manga.rating}
              </p>
              <img
                className="min-h-72 min-w-60 border-background border-4 rounded-md"
                alt="Manga cover"
                src={manga.cover}
              />
            </div>
            <div>
              <p>Capítulos: {manga.numberOfChapters}</p>
              <p>
                Status: {Status[manga.status as unknown as keyof typeof Status]}
              </p>
            </div>
          </aside>
          <section className="flex-grow flex flex-col gap-8 pt-2 pr-4">
            <div className="w-full flex flex-col gap-2">
              <p className="font-semibold text-2xl">{manga.title}</p>
              <div className="w-full flex gap-2 flex-wrap">
                {showCategories()}
              </div>
            </div>
            <div className="w-full">
              <p className="w-full">{renderText()}</p>
            </div>
          </section>
        </div>
      </>
    );
  };

  const showSkeleton = () => {
    return <Skeleton className="col-span-1 h-64 md:h-96 w-full" />;
  };

  return <main>{showManga()}</main>;
}
