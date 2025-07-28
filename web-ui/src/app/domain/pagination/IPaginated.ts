import {IPaginationMetadata} from './IPaginationMetadata';

export interface IPaginated<T> {
    content: T[];
    paginationMetadata: IPaginationMetadata;
}
