import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/user': {
        target: 'http://192.168.67.2:30000',
        changeOrigin: true,
        secure: false,
      },
      '/credit': {
        target: 'http://192.168.67.2:30000',
        changeOrigin: true,
        secure: false,
      },
      '/file': {
        target: 'http://192.168.67.2:30000',
        changeOrigin: true,
        secure: false,
      },
      '/simulation': {
        target: 'http://192.168.67.2:30000',
        changeOrigin: true,
        secure: false,
      },
      '/evaluation': {
        target: 'http://192.168.67.2:30000',
        changeOrigin: true,
        secure: false,
      },
      '/cost': {
        target: 'http://192.168.67.2:30000',
        changeOrigin: true,
        secure: false,
      },
      '/tracking': {
        target: 'http://192.168.67.2:30000',
        changeOrigin: true,
        secure: false,
      },
    },
  },
})
