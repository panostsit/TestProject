// config.service.ts
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {firstValueFrom} from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ConfigService {
  apiUrl!: string;

  constructor(private http: HttpClient) {}

  async loadConfig() {
    const config = await firstValueFrom(this.http.get<{ apiUrl: string; }>('./config.json'));
    if (config?.apiUrl) {
      this.apiUrl = config.apiUrl;
    }
  }
}
