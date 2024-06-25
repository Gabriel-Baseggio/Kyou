import { Manga } from "./manga";

export interface Category {
  category: string;
  mangas: Manga[];
}
