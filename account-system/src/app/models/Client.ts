export interface Client {
    dbid:          number;
    first_name:    string;
    last_name:     string;
    cui:           number;
    nit:           string;
    phone_number:  number;
    email_address: string;
    birthay:       Date;
    marial_status: number;
    status:        number;
    person_type:   number;
    gender:        number;
    registry_date?: string;
    user_registry?: string;
    last_modified?: Date;
    user_modified?: string;
}
