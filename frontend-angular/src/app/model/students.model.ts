export  interface Student{
  id : String;
  code : String;
  firstName : String;
  lastName : String;
  programId : String;
  photo : String;
}

export  interface Payment{
  id : number;
  date : String;
  amount : number;
  type : String;
  status : String;
  file : String;
  student : Student;
}

export interface User{
  id : number;
  username : string;
  email : string;
  nom : string;
  matricule : string;
  password : string;
  isActive : boolean;
  role : string;
  fileName : string;
  resetToken : string;
  dateToken : string;

}

export enum PaymentType{
  CASH,CHECK,TRANSFER,DEPOSIT
}

export enum PaymentStatus{
  CREATE,VALIDATED,REJECTED
}
