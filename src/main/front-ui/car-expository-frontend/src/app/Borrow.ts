import {vehicleDto} from "./vehicleDto";
import {borrowerDto} from "./borrowerDto";

export class Borrow{
  id: number;
  date: string;
  vehicleDto: vehicleDto;
  borrowerDto: borrowerDto;
}
