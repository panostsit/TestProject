import {APP_INITIALIZER, ApplicationConfig, makeEnvironmentProviders, provideBrowserGlobalErrorListeners, provideZoneChangeDetection} from '@angular/core';
import {provideRouter} from '@angular/router';

import {routes} from './app.routes';
import {provideHttpClient} from '@angular/common/http';
import {ConfigService} from '../../public/config.service';
import {configInitializer} from '../main';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(),
    makeEnvironmentProviders([
      {
        provide: APP_INITIALIZER,
        useFactory: configInitializer,
        deps: [ConfigService],
        multi: true,
      }
    ])
  ]
};
