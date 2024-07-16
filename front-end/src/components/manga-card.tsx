"use client";
import { Manga } from "@/interfaces/manga";
import { Card, CardFooter, CardHeader, CardTitle } from "./ui/card";
import { Book, Star } from "lucide-react";
import Link from "next/link";

interface MangaCardProps {
  manga: Manga;
}

export default function MangaCard({ manga }: MangaCardProps) {
  return (
    <Link href={"/manga/" + manga.title}>
      <Card className="w-full aspect-[5/7] flex flex-col justify-end relative ">
        <img
          src={manga.cover}
          alt={manga.title + " cover"}
          className="absolute w-full h-full object-cover z-10 rounded-lg"
        ></img>
        <CardFooter className="relative z-30 flex flex-col items-start gap-4 bg-card rounded-b-lg p-5">
          <CardTitle
            title={manga.title}
            className="w-full min-h-12 line-clamp-2"
          >
            {manga.title}
          </CardTitle>
          <div className="w-full flex justify-between">
            <p className="flex gap-2">
              <Star className="text-foreground" /> {manga.rating}
            </p>
            <p className="flex gap-2">
              {manga.chapters.length} <Book />
            </p>
          </div>
        </CardFooter>
      </Card>
    </Link>
  );
}
