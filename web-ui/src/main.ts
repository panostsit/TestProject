/// <reference types="@angular/localize" />

import {bootstrapApplication} from '@angular/platform-browser';
import {appConfig} from './app/app.config';
import {App} from './app/app';
import {ConfigService} from '../public/config.service';

export function configInitializer(configService: ConfigService): () => Promise<void> {
  return () => configService.loadConfig();
}

bootstrapApplication(App, appConfig)
  .catch((err) => console.error(err));
