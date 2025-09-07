### Instructions

- pull this image as it might take some time - `docker pull vinsdocker/elasticsearch-business-datasetup:latest`
- Run this command `docker compose up`
- This will start `elasticsearch` and `kibana`. NOT `data-setup`.
- Wait for elasticsearch and kibana to be up and running.
- Open another terminal and navigate to the path where you have this yaml file.
- Run this command `docker compose run --rm data-setup`. This will start the data-setup service to setup the indices and add the data.
