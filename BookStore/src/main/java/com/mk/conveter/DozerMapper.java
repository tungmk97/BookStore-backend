package com.mk.conveter;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
  private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

  public static <O, D> D parseObject(O origin, Class<D> destination) {

    return mapper.map(origin, destination);
  }

  public static <O, D> List<D> parseListObject(List<O> origins, Class<D> destination) {
    List<D> destinationObjects = new ArrayList<>();
    origins.forEach(p -> destinationObjects.add(mapper.map(p, destination)));

    return destinationObjects;
  }
}
