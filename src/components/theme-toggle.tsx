"use client";

import { MoonStar, Sun } from "lucide-react";
import { useTheme } from "next-themes";
import { Button } from "@/components/ui/button";
import { useEffect, useState } from "react";
import { Skeleton } from "./ui/skeleton";

export function ThemeToggle() {
  const [mounted, setMounted] = useState(false);
  const { theme, setTheme } = useTheme();

  useEffect(() => {
    setMounted(true);
  }, []);

  if (!mounted) {
    return (
      <Button variant="ghost" size="icon">
        <Skeleton className="rounded-full h-4 w-4 md:h-6 md:w-6" />
        <span className="sr-only">Toggle theme</span>
      </Button>
    );
  }

  const chageTheme = () => {
    if (theme === "light") {
      setTheme("dark");
    } else {
      setTheme("light");
    }
  };

  const defineActive = (themeIcon: string) => {
    return theme === themeIcon ? "block" : "hidden";
  };

  return (
    <Button variant="ghost" size="icon" onClick={chageTheme}>
      <Sun
        className={
          defineActive("light") +
          " h-4 w-4 md:h-6 md:w-6 rotate-0 scale-100 transition-all dark:-rotate-90 dark:scale-0"
        }
      />
      <MoonStar
        className={
          defineActive("dark") +
          " h-4 w-4 md:h-6 md:w-6 rotate-90 scale-0 transition-all dark:rotate-0 dark:scale-100"
        }
      />
      <span className="sr-only">Toggle theme</span>
    </Button>
  );
}
