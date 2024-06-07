export  interface Student{
  id : String;
  code : String;
  firstName : String;
  lasttName : String;
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

export enum PaymentType{
  CASH,CHECK,TRANSFER,DEPOSIT
}

export enum PaymentStatus{
  CREATE,VALIDATED,REJECTED
}
