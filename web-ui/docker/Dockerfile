# Stage 1: Build Angular app
FROM node:22-alpine3.21 as build

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build

# Stage 2: Serve with Nginx
FROM nginx:alpine

# Copy built files from build stage
COPY --from=build /app/dist/*/browser /usr/share/nginx/html

COPY ./docker/nginx.conf /etc/nginx/conf.d/default.conf

# Copy a default config.json placeholder
COPY ./docker/config.default.json /usr/share/nginx/html/assets/config.json

# Copy a startup script that replaces config.json based on env variable
COPY ./docker/docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod +x /docker-entrypoint.sh

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["nginx", "-g", "daemon off;"]
