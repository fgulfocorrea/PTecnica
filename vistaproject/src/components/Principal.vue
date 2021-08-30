<template>
    <Fieldset :legend="titulo">
        <Toolbar>
            <template #left>
                <Button label="Agregar" icon="pi pi-plus" class="p-mr-2"/>
            </template>
        </Toolbar>
        <Accordion>
            <AccordionTab v-for="encuesta in encuestas" :key="encuesta.id" :header="encuesta.nombre" >
              <table>
                <tr>
                  <td>
                    Codigo: {{encuesta.codigo}}
                  </td>
                </tr>
                <tr>
                  <td>
                    <router-link :to="{path:`encuesta/${encuesta.id}`,params:{encuesta:encuesta}}">Iniciar</router-link>
                  </td>
                  <td>
                    <router-link :to="{path:`resultado/${encuesta.id}`,params:{encuesta:encuesta}}">Resultados</router-link>
                  </td>
                </tr>
              </table>
            </AccordionTab>
        </Accordion>
    </Fieldset>
</template>

<script>
/* eslint-disable */
import PrincipalServicio from '@/services/PrincipalServicio';

import Fieldset from 'primevue/fieldset';
import Toolbar from 'primevue/toolbar';
import Button from 'primevue/button';
import Accordion from 'primevue/accordion';
import AccordionTab from 'primevue/accordiontab';

export default {
    name: 'Principal',
    components: {
        Fieldset,
        Toolbar,
        Button,
        Accordion,
        AccordionTab
    },
    data (){
      return {
        titulo: "Listado de Encuestas",
        encuestas:[]
      }
    },
    methods: {

      async obtenerListadoEncuestas() {
        const response = await PrincipalServicio.obtenerEncuestas();
        console.log(response.data)
        this.encuestas = response.data.listaEncuestas
        
        // this.listaUsuarios();
        // this.obtenerCantidadMonedas()
      },
    },
    mounted() {
        this.obtenerListadoEncuestas();
    },
}
</script>

<style>
.titulo1{
  border-bottom-style: inset
}
</style>