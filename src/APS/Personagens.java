package APS;

public class Personagens {

    //Sistema Progressão de nivel e builds

    private int nivel = 1;
    private int xpAtual = 0;
    private int xpProximoNivel = 100;// Sobe pro próximo nível a cada 100 XP


    private String nome;
    private int hp;
    private int maxHp;
    private int atk;
    private int def;

    private int defTemp = 0;

    // Sistema AP
    private int apAtual;
    private int apMax;

    //Xp
    public boolean ganhaXp(int quantidadeXp){
        this.xpAtual += quantidadeXp;
        System.out.println("->" + this.nome + " ganhou " + quantidadeXp + " XP!");

        if (this.xpAtual >= this.xpProximoNivel) {
            this.nivel++;
            this.xpAtual -= this.xpProximoNivel;
            this.xpProximoNivel = (int) (this.xpProximoNivel * 1.5); // Aumenta o XP necessário para o próximo nível

            //restaura Status
            this.hp = this.maxHp;
            this.apAtual = this.apMax;

            return true; // abre janela de Upgrade
        }
        return false;
    }
    
    public int getNivel() {
      return this.nivel;
    }
    //Esquiva
    private boolean esquivando = false;

    public Personagens(String nome, int hp, int atk, int def, int apMax) {
        this.nome = nome;
        this.hp = this.maxHp = hp;
        this.atk = atk;
        this.def = def;
        this.apMax = apMax;
        this.apAtual = apMax;
    }

    public String getNome() { return nome; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAtk() { return atk; }
    public int getDefTotal() { return def + defTemp; }
    public int getApAtual() { return apAtual; }
    public int getApMax() { return apMax; }

    public boolean vivo() {
        return hp > 0;
    }

    
    public void receberDano(int dano) {
        if (esquivando) {
            System.out.println("->" + this.nome + " Esquivou do ataque!");
            return;
        }else{
            hp -= dano;
            if (hp < 0) hp = 0;{
                this.hp = 0;
            }
        }
    }

    public void aumentarHp(int valor) {
        this.maxHp += valor;
        
        if (this.hp > this.maxHp) {
         this.hp = this.maxHp;
      }
    }

    public void aumentarAtk(int valor) {
      this.atk += valor;
   }

   public void aumentarDef(int valor) {
      this.def += valor;
   }

   public void aumentarAp(int valor) {
      this.apAtual += valor;
         
      if (this.apAtual > this.apMax) {
         this.apAtual = this.apMax; 
      }
   }
    
    public void defender(int valorDefesa, int valorRegenAP) {
        this.defTemp = valorDefesa;
        this.apAtual = this.apMax; // Regenera AP ao defender
        
        //impede que o AP passe do máximo
        if (this.apAtual > this.apMax) {
            this.apAtual = this.apMax;
        }
        System.out.println("->" + this.nome + " Defendendo! : " + valorDefesa + ", AP Regenerado: " + valorRegenAP);
    }
    
    //Ação Esquiva
    public boolean esquiva(int custoAp) {
        if(this.apAtual >= custoAp) {
            this.apAtual -= custoAp;
            this.esquivando = true;
            System.out.println("->" + this.nome + " gastou " + custoAp + " AP para esquivar!");
            return true;
        } else{
            System.out.println("->" + this.nome + " Sem Agilidade suficiente para esquivar!");
            return false;
        }
    }
    
    //Gastando AP
    public boolean gastarAp(int custo) {
        if (apAtual >= custo) {
            apAtual -= custo;
            return true;
        }else {
            System.out.println("->" + this.nome + " Sem Agilidade suficiente!");
            return false;
        }
    }

    //Regenerando AP
    public void regenerarAp(int valor) {
      this.apAtual += valor;
      
      if (this.apAtual > this.apMax) {
         this.apAtual = this.apMax; 
      }
   }

    //Regenerando HP
    public void regenerarHp(int valor) {
      this.hp += valor;
      
      if (this.hp > this.maxHp) {
         this.hp = this.maxHp; 
      }   
    }
    public void resetTurno() {
        this.defTemp = 0;
        this.esquivando = false;
    }
}