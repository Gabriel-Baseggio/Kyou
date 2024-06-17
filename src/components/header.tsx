"use client";

import Link from "next/link";
import { ThemeToggle } from "./theme-toggle";
import { BookCopy, Home, LogIn, Search, User2 } from "lucide-react";
import { Input } from "./ui/input";
import SideBar from "./side-bar";
import { SheetClose } from "./ui/sheet";
import TooltipArea from "./tooltip-area";

export default function Header() {
  return (
    <header className="flex h-16 items-center justify-between gap-4 border-b bg-background px-4 md:px-6">
      <SideBar>
        <SheetClose asChild>
          <Link
            href="/"
            className="flex items-center gap-2 text-base font-semibold md:text-base"
          >
            <Home className="h-4 w-4" />
            Home
          </Link>
        </SheetClose>
        <SheetClose asChild>
          <Link
            href="/catalogo"
            className="flex items-center gap-2 text-base font-semibold md:text-base"
          >
            <BookCopy className="h-4 w-4" />
            Catálogo
          </Link>
        </SheetClose>
        <SheetClose asChild>
          <Link
            href="/login"
            className="flex items-center gap-2 text-base font-semibold md:text-base"
          >
            <LogIn className="h-4 w-4" />
            Login
          </Link>
        </SheetClose>
      </SideBar>

      <nav className="hidden flex-col gap-6 text-lg font-medium md:flex md:flex-row md:items-center md:gap-5 md:text-sm lg:gap-6">
        <TooltipArea tooltipText="Home">
          <Link
            href="/"
            className="font-medium text-base md:font-bold md:text-2xl"
          >
            Kyou
          </Link>
        </TooltipArea>
        <TooltipArea tooltipText="Catálogo">
          <Link
            href="/catalogo"
            className="flex items-center gap-2 text-lg font-semibold md:text-base"
          >
            <BookCopy className="h-4 w-4 md:h-6 md:w-6" />
          </Link>
        </TooltipArea>
      </nav>

      <form className="ml-auto flex-1 sm:flex-initial">
        <div className="relative">
          <Search className="absolute left-2.5 top-2.5 h-4 w-4 text-muted-foreground" />
          <Input
            type="search"
            placeholder="Procurar obras"
            className="pl-8 sm:w-[300px] md:w-[200px] lg:w-[300px]"
          />
        </div>
      </form>

      <TooltipArea tooltipText="Tema">
        <ThemeToggle></ThemeToggle>
      </TooltipArea>
      <TooltipArea tooltipText="Perfil">
        <Link
          href="/perfil"
          className="flex items-center gap-2 text-lg font-semibold md:text-base"
        >
          <User2 className="h-4 w-4 md:h-6 md:w-6" />
        </Link>
      </TooltipArea>
    </header>
  );
}
