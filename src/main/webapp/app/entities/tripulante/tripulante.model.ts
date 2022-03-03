import { IVuelo } from 'app/entities/vuelo/vuelo.model';

export interface ITripulante {
  id?: number;
  nombre?: string;
  apelidos?: string;
  dni?: string;
  direccion?: string;
  email?: string;
  fotoContentType?: string;
  foto?: string;
  vuelos?: IVuelo[] | null;
}

export class Tripulante implements ITripulante {
  constructor(
    public id?: number,
    public nombre?: string,
    public apelidos?: string,
    public dni?: string,
    public direccion?: string,
    public email?: string,
    public fotoContentType?: string,
    public foto?: string,
    public vuelos?: IVuelo[] | null
  ) {}
}

export function getTripulanteIdentifier(tripulante: ITripulante): number | undefined {
  return tripulante.id;
}
