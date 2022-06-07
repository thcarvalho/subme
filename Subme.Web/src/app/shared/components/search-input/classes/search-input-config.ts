import { SearchParams } from "src/app/shared/classes/params/search-params";

export class SearchInputConfig {
  params!: SearchParams[];
  searchAction!: (query: any) => void;
}
