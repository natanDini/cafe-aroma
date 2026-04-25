import type { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'br.com.cpet.cafearoma',
  appName: 'Café Aroma',
  webDir: 'www',
  android: {
    allowMixedContent: true
  },
  server: {
    androidScheme: 'https',
    cleartext: false
  }
};

export default config;