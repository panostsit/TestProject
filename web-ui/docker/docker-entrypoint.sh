#!/bin/sh
set -e

# Default backend URL if not passed in env
API_URL=${API_URL:-http://localhost:8080}

# Create a new config.json with the backend URL
cat <<EOF > /usr/share/nginx/html/assets/config.json
{
  "apiUrl": "${API_URL}"
}
EOF

# Execute the CMD
exec "$@"
