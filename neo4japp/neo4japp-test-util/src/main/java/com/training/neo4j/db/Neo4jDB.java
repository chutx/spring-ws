package com.training.neo4j.db;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.kernel.GraphDatabaseAPI;
import org.neo4j.server.WrappingNeoServerBootstrapper;
import org.neo4j.server.configuration.Configurator;
import org.neo4j.server.configuration.ServerConfigurator;

import com.training.neo4j.db.factory.Neo4JDBFactory;

@SuppressWarnings("deprecation")
public class Neo4jDB {
	private GraphDatabaseAPI graphdb;

	private WrappingNeoServerBootstrapper serverBoot;

	public Neo4jDB() {
		String path = "data/graph.db";
		Neo4JDBFactory dbFactory = new Neo4JDBFactory();
		GraphDatabaseService dbService = dbFactory.newEmbeddedDatabase(path);
		
		graphdb = (GraphDatabaseAPI) dbService;
		ServerConfigurator serverConfig = createAndPrepateServerConfiguration(graphdb);

		serverBoot = new WrappingNeoServerBootstrapper(graphdb, serverConfig);
	}

	public Integer start() {
		return serverBoot.start();
	}

	public void stop() {
		serverBoot.stop();
	}

	private ServerConfigurator createAndPrepateServerConfiguration(GraphDatabaseAPI graphdb) {
		ServerConfigurator serverConfig = new ServerConfigurator(graphdb);
		serverConfig.configuration().setProperty(Configurator.WEBSERVER_PORT_PROPERTY_KEY, 7575);
		return serverConfig;
	}
}
