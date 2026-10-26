# Use a lightweight Node image
FROM node:lts-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy package files and install dependencies (if any)
COPY package*.json ./
RUN npm install

# Copy the rest of your app source code
COPY . .

# Expose the port your web server will run on
EXPOSE 3000

# Command to start your application
CMD ["npx", "serve", "public", "-l", "3000"]