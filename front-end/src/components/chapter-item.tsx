"use client";
import Link from "next/link";
import { Chapter } from "@/interfaces/chapter";
import { usePathname } from "next/navigation";
import { BookOpen } from "lucide-react";

interface ChapterItemProps {
  chapter: Chapter;
}

export default function ChapterItem({ chapter }: ChapterItemProps) {
  const pathname = usePathname();

  return (
    <Link
      className="w-full flex gap-2 p-4 rounded-lg bg-muted hover:bg-muted/50 cursor-pointer"
      href={pathname + "/" + chapter.chapter}
    >
      <BookOpen />
      Capítulo {chapter.chapter}
    </Link>
  );
}
