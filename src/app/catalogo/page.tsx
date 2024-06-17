"use client";

import MangaCard from "@/components/manga-card";
import { Skeleton } from "@/components/ui/skeleton";
import { Manga } from "@/interfaces/manga";

export default function CatalogoPage() {
  const mangas: Manga[] = [
    {
      id: 1,
      title: "Naruto",
      image:
        "https://http2.mlstatic.com/D_NQ_NP_755575-MLU50423880781_062022-O.webp",
      numberOfChapters: 700,
      rating: 4.5,
    },
    {
      id: 2,
      title: "One Piece",
      image:
        "https://rebootcomics.com.br/wp-content/uploads/2024/02/170692117029-324x477.webp",
      numberOfChapters: 1000,
      rating: 4.8,
    },
    {
      id: 3,
      title: "Attack on Titan",
      image:
        "https://upload.wikimedia.org/wikipedia/en/0/0f/Shingeki_no_Kyojin_manga_volume_1.jpg",
      numberOfChapters: 139,
      rating: 4.7,
    },
    {
      id: 4,
      title: "Fullmetal Alchemist",
      image:
        "https://upload.wikimedia.org/wikipedia/en/8/81/Fullmetal_Alchemist_1.png",
      numberOfChapters: 116,
      rating: 4.6,
    },
    {
      id: 5,
      title: "Death Note",
      image:
        "https://upload.wikimedia.org/wikipedia/en/6/6f/Death_Note_Vol_1.jpg",
      numberOfChapters: 108,
      rating: 4.9,
    },
    {
      id: 6,
      title: "Dragon Ball",
      image:
        "https://upload.wikimedia.org/wikipedia/en/6/6f/Dragon_Ball_volume_1_cover.jpg",
      numberOfChapters: 519,
      rating: 4.4,
    },
    {
      id: 7,
      title: "My Hero Academia",
      image:
        "https://upload.wikimedia.org/wikipedia/en/4/4e/My_Hero_Academia_Volume_1.png",
      numberOfChapters: 300,
      rating: 4.6,
    },
    {
      id: 8,
      title: "Tokyo Ghoul",
      image:
        "https://upload.wikimedia.org/wikipedia/en/5/56/Tokyo_Ghoul_volume_1_cover.jpg",
      numberOfChapters: 143,
      rating: 4.5,
    },
    {
      id: 9,
      title: "One Punch Man",
      image:
        "https://upload.wikimedia.org/wikipedia/en/6/60/OnePunchMan_manga_cover.png",
      numberOfChapters: 150,
      rating: 4.7,
    },
    {
      id: 10,
      title: "Bleach",
      image:
        "https://upload.wikimedia.org/wikipedia/en/8/8c/Bleach_volume_1_cover.jpg",
      numberOfChapters: 686,
      rating: 4.3,
    },
  ];

  const mostrarMangas = () => {
    if (!mangas || mangas.length === 0) {
      return null;
    }
    return mangas.map((manga) => <MangaCard key={manga.id} manga={manga} />);
  };

  const mostrarSkeleton = () => {
    return <Skeleton className="w-full h-10" />;
  };

  return (
    <main>
      <div className="w-full px-16 py-8 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-4">
        {mostrarMangas() || mostrarSkeleton()}
      </div>
    </main>
  );
}
