"use client";

import { Manga } from "@/interfaces/manga";
import Image from "next/image";
import { useEffect, useState } from "react";

export default function MangaPage({ params }: { params: { title: string } }) {
  let [manga, setManga] = useState<Manga | null>(null);

  useEffect(() => {
    fetch(`/api/manga/${params.title}`)
      .then((res) => res.json())
      .then((data) => setManga(data));
  }, []);

  return (
    <main>
      <Image
        alt="Background image"
        src={"/covers/" + manga?.image}
        width={1000}
        height={1000}
      ></Image>
    </main>
  );
}
