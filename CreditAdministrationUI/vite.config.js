import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/user': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      },
      '/credit': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      },
      '/file': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      },
      '/simulation': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      },
      '/evaluation': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      },
      '/cost': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      },
    },
  },
})
