import { Person } from "./person";
import { RequestType } from "./request-type";
import { RequestPurpose } from "./request-purpose";
import { User } from "./user";

export class ConnectionRequestForm {
    id: number;
    submissionDate: Date;
    submitter: Person;
    requestType: RequestType;
    requestPurpose: RequestPurpose;
    author: User;
}
