import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { shareReplay } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class WebClientService {

  readonly DOMAIN_URL : string

  constructor(private httpClient : HttpClient) {
    this.DOMAIN_URL = "http://localhost:8080";
   }

  getData(endpoint){
    return this.httpClient.get(`${this.DOMAIN_URL}/${endpoint}`);
  }

  auth(endpoint : string, payload : any){
    return this.httpClient.post(`${this.DOMAIN_URL}/${endpoint}`, payload).pipe(shareReplay(1));
  }

  postData(endpoint : string, payload : any){
    return this.httpClient.post(`${this.DOMAIN_URL}/${endpoint}`, payload);
  }
}
