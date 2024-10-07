package com.labmedicine.api_labmedication.models;

public enum TipoMedicamento {
        CAPSULA(0L),
        COMPRIMIDO(1L),
        LÍQUIDO(2L),
        CREME(3L),
        GEL(4L),
        INALAÇÃO(5L),
        INJEÇÃO(6L),
        SPRAY(7L);

        private final Long id;

        TipoMedicamento(Long id) {
                this.id = id;
        }

        public Long getId() {
                return id;
        }

        public static TipoMedicamento fromId(Long id) {
                for (TipoMedicamento tipo : TipoMedicamento.values()) {
                        if (tipo.getId().equals(id)) {
                                return tipo;
                        }
                }
                throw new IllegalArgumentException("ID inválido para TipoMedicamento: " + id);
        }
}
