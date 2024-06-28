"use client";

import Link from "next/link";

export default function Footer() {
  return (
    <footer className="flex h-16 mt-8 items-center justify-center gap-4 border-bg bg-secondary/50 px-4 md:px-6">
      <p>
        Desenvolvido por:{" "}
        <Link
          className="font-bold"
          href={"https://github.com/Gabriel-Baseggio"}
        >
          Gabriel Baseggio
        </Link>
      </p>
    </footer>
  );
}
