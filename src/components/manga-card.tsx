"use client";
import { Manga } from "@/interfaces/manga";
import { Card, CardFooter, CardHeader, CardTitle } from "./ui/card";
import { Book, Star } from "lucide-react";

interface MangaCardProps {
  manga: Manga;
}

export default function MangaCard({ manga }: MangaCardProps) {
  console.log(manga.image);

  return (
    <Card
      className={
        "w-auto flex flex-col justify-between h-64 md:h-96 relative bg-cover bg-center bg-origin-border bg-clip-border bg-[url('" +
        manga.image +
        "')] bg-opacity-10"
      }
    >
      <div className="absolute w-full h-full bg-card/60 z-10"></div>
      <CardHeader className="relative z-20">
        <CardTitle>{manga.title}</CardTitle>
      </CardHeader>
      <CardFooter className="relative z-20 flex justify-between">
        <p className="flex gap-2">
          <Star className="text-yellow-300" /> {manga.rating}
        </p>
        <p className="flex gap-2">
          {manga.numberOfChapters} <Book />
        </p>
      </CardFooter>
    </Card>
  );
}
