package com.like.common.dto;

import java.io.Serializable;

///
/// Html select tag, Option tag		<br>
/// label, value (Record) 			<br>
/// Ex) 							<br>
/// ```java
/// List<HtmlSelectOptionRecord> list = new ArrayList<HtmlSelectOptionRecord>();
/// 
/// // for loop
/// for (EnumType type : EnumType.values()) {
///     list.add(new HtmlSelectOptionRecord(type.getDescription(), type.toString()));
/// }
/// 
/// // Java 8 Streams
/// list = Arrays.stream(EnumType.values())
///				 .map(e -> new HtmlSelectOptionRecord(e.getDescription(), e.toString()))
///				 .toList();
/// ```
/// 
public record HtmlSelectOptionRecord(String label, String value) implements Serializable {}
