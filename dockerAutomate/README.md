# Automatization
## **Note:** Remind that you have to put this files outside of the projects and the folder need the next structure:
```
├── docker-compose.yml
├── docker-drop-project.sh
├── docker-start-project.sh
├── eureka-server
├── inspection-db
├── pica-employee
├── pica-historic
├── pica-inspection
├── pica-location
├── pica-supervisor
└── zuul-proxy
```

Then execute `docker-start-project.sh` this script will initialize the docker stack
If you want to down all the projects and database please use `docker-drop-project.sh` 