<template>
    <Fieldset :legend="titulo">
        <Toolbar>
            <template #left>
                <Button label="Agregar" icon="pi pi-plus" class="p-mr-2" />
            </template>
        </Toolbar>
    </Fieldset>
</template>

<script>
/* eslint-disable */
import ResponsableServicio from '@/services/ResponsableServicio';

import Fieldset from 'primevue/fieldset';
import Toolbar from 'primevue/toolbar';
import Button from 'primevue/button';

export default {
    name: 'AddEncuesta',
    components: {
        Fieldset,
        Toolbar,
        Button
    },
    data (){
      return {
        titulo: "Nueva Encuesta",
        encuesta:{
            codigo,
            nombre,
            fechaInicio,
            fechaFin,
            responsable,
            activa
        },
        responsables:[]
      }
    },
    methods: {

      async obtenerListadoResponsables() {
        const response = await ResponsableServicio.obtenerResponsables();
        console.log(response.data)
        this.responsables = response.data.listaResponsables
        
        // this.listaUsuarios();
        // this.obtenerCantidadMonedas()
      },
    },
    mounted() {
        this.obtenerListadoResponsables();
    },
}
</script>

<style>
.titulo1{
  border-bottom-style: inset
}
</style>