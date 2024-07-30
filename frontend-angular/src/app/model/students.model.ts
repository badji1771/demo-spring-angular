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
  ville : Ville;
}

export interface User{
  id : number;
  username : string;
  email : string;
  nom : string;
  matricule : string;
  password : string;
  isActive : boolean;
  role : Role;
  fileName : string;
  resetToken : string;
  dateToken : string;

}

export interface Role{
  id : number;
  code : string;
  libelle : string;
  isActive : boolean;
}

export interface Ville{
  id : number;
  code : string;
  libelle : string;
}

export interface UserRole{
  id : number;
  role : Role;
  user : User;
  codeRole : string;
  matriculeUser : string;
}

export enum PaymentType{
  CASH,CHECK,TRANSFER,DEPOSIT
}

export enum PaymentStatus{
  CREATE,VALIDATED,REJECTED
}
