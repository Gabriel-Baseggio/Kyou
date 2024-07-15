import { Manga } from "./manga";
import { Page } from "./page";

export interface Chapter {
  chapter: number;
  pages: Page[];
}
