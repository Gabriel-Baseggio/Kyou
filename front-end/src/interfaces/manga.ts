import { Category } from "./category";
import { Chapter } from "./chapter";
import { Status } from "./status";

export interface Manga {
  title: string;
  banner: string;
  cover: string;
  rating: number;
  description: string;
  status: Status;
  categories: Category[];
  chapters: Chapter[];
}
