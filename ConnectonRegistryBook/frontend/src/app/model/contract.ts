import { Person } from "./person";
import { User } from "./user";

export class Contract {
    id: number;
    signingDate: Date;
    contractor: Person;
    responsiblePerson: string;
    author: User;
}
