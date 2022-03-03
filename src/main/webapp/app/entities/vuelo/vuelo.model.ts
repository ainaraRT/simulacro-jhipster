import { IAeropuerto } from 'app/entities/aeropuerto/aeropuerto.model';
import { IAvion } from 'app/entities/avion/avion.model';
import { IPiloto } from 'app/entities/piloto/piloto.model';
import { ITripulante } from 'app/entities/tripulante/tripulante.model';

export interface IVuelo {
  id?: number;
  pasaporteCovid?: boolean;
  numeroDeVuelo?: string;
  origen?: IAeropuerto;
  destino?: IAeropuerto;
  avion?: IAvion;
  piloto?: IPiloto;
  tripulantes?: ITripulante[];
}

export class Vuelo implements IVuelo {
  constructor(
    public id?: number,
    public pasaporteCovid?: boolean,
    public numeroDeVuelo?: string,
    public origen?: IAeropuerto,
    public destino?: IAeropuerto,
    public avion?: IAvion,
    public piloto?: IPiloto,
    public tripulantes?: ITripulante[]
  ) {
    this.pasaporteCovid = this.pasaporteCovid ?? false;
  }
}

export function getVueloIdentifier(vuelo: IVuelo): number | undefined {
  return vuelo.id;
}
