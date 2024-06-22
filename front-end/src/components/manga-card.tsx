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
      <Card className="w-auto flex flex-col justify-end h-64 md:h-96 relative ">
        <img
          src={manga.cover}
          alt={manga.title + " cover"}
          className="absolute w-full h-full object-cover z-10 rounded-lg"
        ></img>
        <CardFooter className="relative z-30 flex flex-col items-start gap-8 bg-card rounded-b-lg p-5">
          <CardTitle>{manga.title}</CardTitle>
          <div className="w-full flex justify-between">
            <p className="flex gap-2">
              <Star className="text-foreground" /> {manga.rating}
            </p>
            <p className="flex gap-2">
              {manga.numberOfChapters} <Book />
            </p>
          </div>
        </CardFooter>
      </Card>
    </Link>
  );
}
