package pe.edu.upeu.syscenterlife.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuMenuItenTO {
    public String menunombre, menuitemnombre, nombreObj;
}
