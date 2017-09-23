//package br.com.marlene.joias.json.serializer;
//
//import java.lang.reflect.Type;
//
//import com.google.gson.ExclusionStrategy;
//import com.google.gson.FieldAttributes;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonSerializationContext;
//import com.google.gson.JsonSerializer;
//
//import br.com.marlene.joias.modelo.venda.Compra;
//
//public class CompraSerializer implements JsonSerializer<Compra> {
//
//	@Override
//	public JsonElement serialize(Compra compra, Type typeOfSrc, JsonSerializationContext context) {
//		JsonObject root = new JsonObject();
//
//		root.addProperty("id", compra.getId());
//		root.addProperty("valorDaEntrada", compra.getValorDaEntrada());
//		root.addProperty("aVista", compra.isaVista());
//		root.addProperty("quitado", compra.isQuitado());
//		root.addProperty("entrada", compra.hasEntrada());
//
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//
//		root.add("dataDeCriacao", gson.toJsonTree(compra.getDataDeCriacao()));
//		root.add("dataPrimeiraParcela", gson.toJsonTree(compra.getDataPrimeiraParcela()));
//
//		gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
//
//			public boolean shouldSkipClass(Class<?> clazz) {
//				return (clazz == Compra.class);
//			}
//
//			/**
//			 * Custom field exclusion goes here
//			 */
//			public boolean shouldSkipField(FieldAttributes f) {
//				return f.getClass().equals(Compra.class);
//			}
//
//		}).create();
//
//		root.add("cliente", gson.toJsonTree(compra.getCliente()));
//		root.add("parcelas", gson.toJsonTree(compra.getParcelas()));
//		root.add("itens", gson.toJsonTree(compra.getItens()));
//
//		return root;
//	}
//
//}