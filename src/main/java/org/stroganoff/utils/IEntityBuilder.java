package org.stroganoff.utils;

import org.stroganoff.entities.Gem;
import org.w3c.dom.Element;

public interface IEntityBuilder {
    Gem buildGem(Element element);
}
