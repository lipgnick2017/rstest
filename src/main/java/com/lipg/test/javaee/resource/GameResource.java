package com.lipg.test.javaee.resource;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.lipg.test.javaee.resource.model.Game;
import com.lipg.test.javaee.resource.model.Player;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import javax.ws.rs.core.MediaType;
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class GameResource {
	@Path("/game")
    @GET
    @Operation(summary = "get information of current game", description = "get information of current game", tags = {
            "Game" }, responses = {
                    @ApiResponse(responseCode = "200", description = "the query is successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Game.class)))

    })
	public Game getGame() {
		return Game.mock();
	}
	
	
	@Path("/players")
    @GET
    @Operation(summary = "get all the players of current game", description = "get all the players of current game", tags = {
            "Player" }, responses = {
                    @ApiResponse(responseCode = "200", description = "the query is successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Player.class)))

    })
	public List<Player> getPlayers(){
		return Player.players();
	}
	
	
	 @Path("/player/{name}")
	    @GET
	    @Operation(summary = "Get a single player by name", description = "Get a single player by name", tags = {
	            "Player" }, responses = {
	                    @ApiResponse(responseCode = "200", description = "successfully got the player", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Player.class))),
	                    @ApiResponse(responseCode = "400", description = "can not find such player")

	    })
	public Player getPlayer(@Parameter(description = "player name", required = true) @PathParam("name") String name) {
		Optional<Player> op=Player.players().stream().filter(p->name.equalsIgnoreCase(p.getName())).findFirst();
		if(op.isPresent()) {
			return op.get();
		}
		throw new NotFoundException(String.format("No such player with name %s",name));
	}
}
