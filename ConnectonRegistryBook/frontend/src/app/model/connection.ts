import { ConnectionRequestForm } from "./connection-request-form";
import { Contract } from "./contract";
import { ConnectionCategory } from "./connection-category";
import { WorkOrder } from "./work-order";
import { Person } from "./person";
import { Status } from "./status";
import { Municipality } from "./municipality";
import { ConnectionPurpose } from "./connection-purpose";

export class Connection {
    id: number;
    requestForm: ConnectionRequestForm;
    contract: Contract;
    connectionCategory: ConnectionCategory;
    connectionDate: Date;
    workOrder: WorkOrder;
    registryBookNo: string;
    owner: Person;
    status: Status;
    cadastralParcelNo: string;
    cadastralMunicipality: Municipality;
    settlementArea: string;
    address: string;
    connectionPurpose: ConnectionPurpose;
    hasDrainage: boolean;
    documentation: string;
    
}