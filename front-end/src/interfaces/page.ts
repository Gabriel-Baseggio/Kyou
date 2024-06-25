import { Chapter } from "./chapter";

export interface Page {
  number: number;
  pageImage: string;
  chapter: Chapter;
}
