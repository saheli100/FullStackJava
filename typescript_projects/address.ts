class Address {
        private _addressLine1: string;
        private _addressLine2: string;
        private _city: string;
        constructor(addressLine1: string, addressLine2: string, city: string) {
            this._addressLine1 = addressLine1;
            this._addressLine2 = addressLine2;
            this._city = city;
        }
        public set addressLine1(line1: string) {
            this._addressLine1 = line1;
        }
        public set addressLine2(line2: string) {
            this._addressLine2 = line2;
        }
        public set city(c: string) {
            this._city = c;
        }
        public get addressLine1(): string {
            return this._addressLine1;
        }
        public get addressLine2(): string {
            return this._addressLine2;
        }
        public get city(): string {
            return this._city;
        }
    }
    class Customer {
        private _firstName: string;
        private _lastName: string;
        private _address: Address;
        constructor(fName: string, lName: string, address: Address) {
            this._firstName = fName;
            this._lastName = lName;
            this._address = address;
        }
        public set firstName(fName:string)
        {
            this._firstName=fName;
        }
        public set lastName(lName:string)
        {
            this._lastName=lName;
        }
        public set address(add:Address)
        {
            this._address=add;
        }
        public get firstName():string
        {
            return this._firstName;
        }
        public get lastName():string
        {
            return this._lastName;
        }
        public get address():Address
        {
            return this._address;
        }
    }
    let myAddress=new Address("Telengana","India","Hyderabad");
    let myCustomer=new Customer("Ram","Kumar",myAddress);
    console.log("First Name Is: "+myCustomer.firstName);
    console.log("Last Name: "+myCustomer.lastName);
    console.log("Address As Follows: \n"+myCustomer.address.addressLine1+" "+myCustomer.address.addressLine2+" "+myCustomer.address.city);
    