import MangaCard from "@/components/manga-card";
import { Skeleton } from "@/components/ui/skeleton";
import { Manga } from "@/interfaces/manga";

export default function CatalogoPage() {
  const mangas: Manga[] = [
    {
      id: 1,
      title: "Naruto",
      image: "naruto.jpg",
      numberOfChapters: 700,
      rating: 4.5,
    },
    {
      id: 2,
      title: "One Piece",
      image: "one-piece.jpg",
      numberOfChapters: 1000,
      rating: 4.8,
    },
    {
      id: 3,
      title: "Attack on Titan",
      image: "attack-on-titan.webp",
      numberOfChapters: 139,
      rating: 4.7,
    },
    {
      id: 4,
      title: "Fullmetal Alchemist",
      image: "fullmetal-alchemist.webp",
      numberOfChapters: 116,
      rating: 4.6,
    },
    {
      id: 5,
      title: "Death Note",
      image: "death-note.jpg",
      numberOfChapters: 108,
      rating: 4.9,
    },
    {
      id: 6,
      title: "Dragon Ball",
      image: "dragon-ball.webp",
      numberOfChapters: 519,
      rating: 4.4,
    },
    {
      id: 7,
      title: "My Hero Academia",
      image: "my-hero-academia.jpg",
      numberOfChapters: 300,
      rating: 4.6,
    },
    {
      id: 8,
      title: "Tokyo Ghoul",
      image: "tokyo-ghoul.jpg",
      numberOfChapters: 143,
      rating: 4.5,
    },
    {
      id: 9,
      title: "One Punch Man",
      image: "one-punch-man.jpg",
      numberOfChapters: 150,
      rating: 4.7,
    },
    {
      id: 10,
      title: "Bleach",
      image: "bleach.jpg",
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
      <div className="w-full px-16 py-8 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-4">
        {mostrarMangas() || mostrarSkeleton()}
      </div>
    </main>
  );
}
