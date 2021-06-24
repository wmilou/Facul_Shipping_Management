#ifndef TDALISTA_H_INCLUDED
#define TDALISTA_H_INCLUDED

/* Nomes Alunos
 *  Vinicius Oliveira          RA: 72507
 *  Wedlsey Milouchine         RA: 73183
 *  Carolina Rodrigues         RA: 68097
 *  Eduardo Oliveira Batista   RA: 73026
 *  Genildo Santos             RA: 77846
 */

struct no {
	struct no *ant;
	double id, distance; 
	struct no *prox;
};
struct TipoLista {
	struct no *inicio;	// o primeiro nó da lista
	struct no *fim;	// o último nó
};

// Inicializa a Lista
void Inicializa (struct TipoLista *lista) {
	lista->inicio=NULL;
	lista->fim=NULL;
}

// Verifica se a lista está vazia
int Vazia (struct TipoLista *lista) {
	return (lista->inicio==NULL && lista->fim==NULL);
}

// Lista
void Imprime(struct TipoLista *lista) {
	struct no *aux = lista->inicio;
	while(aux!=NULL) {
		printf("%.2f , %.2f\n", aux->id, aux->distance);
		aux=aux->prox;
	}
}

// Organiza Lista 
double BuscaMenorDistancia(struct TipoLista *lista ) {
    struct no *aux=lista->inicio;
    struct no *aux_tmp=lista->inicio;

    double id = aux->id;
    double distance = aux->distance;

    double prox_id;
    double prox_distance;

    int i;
    for (i = 0; i == i; i++){

        if (aux->prox == NULL){
            break;
        }

        aux=aux->prox;

        if(distance > aux->distance){
            distance = aux->distance;
            id = aux->id;
        }
    }
    return id;
}

// Insere Nó
void Insere(double id, double distance, struct TipoLista *lista) {
    struct no *novo;
	novo = (struct no *) malloc(sizeof(struct no));
	novo->id = id;
	novo->distance = distance;
	novo->ant=novo->prox=NULL;
	if (Vazia(lista)) {
		lista->inicio=novo;
	}
	else {
		lista->fim->prox=novo;
		novo->ant=lista->fim;
	}
	lista->fim=novo;
}


// Retira Nó específico
void Retira_Pos (int pos, struct TipoLista *lista) {
	struct no *aux, *proximo, *anterior;
	aux = proximo = anterior = lista->inicio;
	int cont=1;
	int achou=0;
	if(pos==1) {    // se for o primeiro
		printf("\nvai remover");
		lista->inicio=lista->inicio->prox;
		lista->inicio->ant=NULL;
		achou=1;
		free(aux);
	}
	else {  // se não for o primeiro
		while (aux->prox!=NULL && cont<pos) {
			cont++;
			anterior=aux;
			aux=aux->prox;
			proximo=aux->prox;
		}
		if(cont==pos) {  // se encontrou a posição
			printf("\nvai remover");
			if(aux==lista->fim) {  // se for o último da lista
				anterior->prox=NULL;
				lista->fim=anterior;
			}
			else {	// se estiver no meio da lista
				anterior->prox=proximo;
				proximo->ant=anterior;
			}
			achou=1;
			free(aux);  // libera o aux
		}
	}
	if(achou==0) {  // se não existir a posição
		printf("\nNao existe o %io elemento",pos);
	}
}

// Retira Nó
void Retira_Elem (double id, struct TipoLista *lista) {
	struct no *aux, *proximo, *anterior;
	aux = proximo = anterior = lista->inicio;
	int cont=1;
	int achou=0;
	if(id==lista->inicio->id) {    // se for o primeiro
		printf("\nvai remover");
		lista->inicio=lista->inicio->prox;
		lista->inicio->ant=NULL;
		achou=1;
		free(aux);
	}
	else {  // se não for o primeiro
		while (aux->prox!=NULL && aux->id!=id) {
			cont++;
			anterior=aux;
			aux=aux->prox;
			proximo=aux->prox;
		}
		if(aux->id==id) {  // se encontrou o elemento
			printf("\nvai remover");
			if(aux==lista->fim) {  // se for o último da lista
				anterior->prox=NULL;
				lista->fim=anterior;
			}
			else {	// se estiver no meio da lista
				anterior->prox=proximo;
				proximo->ant=anterior;
			}
			achou=1;
			free(aux);  // libera o aux
		}
	}
	if(achou==0) {  // se não existir o elemento
		printf("\nNao existe o  elemeno %i ",id);
	}
}
// consulta
void Consulta(double id, struct TipoLista *lista) {
	struct no *aux;
	aux = lista->inicio;
	int cont=1;
	while (aux->prox!=NULL && aux->id!=id) {
		cont++;
		aux=aux->prox;
	}
	if(aux->id==id) {  // se encontrou o elemento
		printf("\n%d encontrado na posicao %d", id, cont);
	}
	else {
		printf("\nNao existe o  elemento %i ",id);
	}
}

#endif // TDALISTA_H_INCLUDED
